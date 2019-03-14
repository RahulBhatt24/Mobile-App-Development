package com.example.saicm.riverraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GameSurface gameSurface;
    ConstraintLayout layout;
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameSurface = new GameSurface(this);
        setContentView(gameSurface);
        layout = findViewById(R.id.layout);
    }

    @Override
    protected void onPause(){
        super.onPause();
        gameSurface.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        gameSurface.resume();
    }



    //----------------------------GameSurface Below This Line--------------------------
    public class GameSurface extends SurfaceView implements Runnable,SensorEventListener{

        private static final String TAG = "GameSurface";
        Thread gameThread;
        SurfaceHolder holder;
        volatile boolean running = false;
        Bitmap plane;
        int score = -1;
        int ax = 0;
        int ay = 0;
        int x;
        int y;
        int time = 99;
        int realtime = 30;
        int bulletcounter = 0;
        boolean game = false;
        Canvas canvas;
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        String sensorOutput="";
        Paint paintProperty;

        MediaPlayer bullethit;
        MediaPlayer backgroundmusic;

        int screenWidth;
        int screenHeight;

        public GameSurface(Context context) {
            super(context);
            holder=getHolder();
            plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane);

            Display screenDisplay = getWindowManager().getDefaultDisplay();
            Point sizeOfScreen = new Point();
            screenDisplay.getSize(sizeOfScreen);
            screenWidth=sizeOfScreen.x;
            screenHeight=sizeOfScreen.y;
            x = (screenWidth/2) - plane.getWidth()/2;
            y = (2*screenHeight/3) - plane.getHeight();

            bullethit = MediaPlayer.create(MainActivity.this, R.raw.bullethit);
            backgroundmusic = MediaPlayer.create(MainActivity.this, R.raw.backgroundmusic);
            SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometerSensor,sensorManager.SENSOR_DELAY_NORMAL);

            paintProperty= new Paint();
            paintProperty.setTextSize(64);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (game == false && score == -1) {
                score = 0;
                game = true;
            } else if (game == false && score > -1) {
                obstacles.clear();
                x = (screenWidth/2) - plane.getWidth()/2;
                y = (2*screenHeight/3) - plane.getHeight();
                score = 0;
                bulletcounter = 0;
                time = 99;
                realtime = 30;
                game = true;
            }

            if (bulletcounter < 3) {
                obstacles.add(new Bullet(x + plane.getWidth() / 2, y - 10));
                bulletcounter++;
            }
            return super.onTouchEvent(event);
        }

        @Override
        public void run() {

            while (running == true){

                if (holder.getSurface().isValid() == false)
                    continue;
                canvas= holder.lockCanvas();

                if (realtime < 1) {
                    game = false;
                }

                if (!backgroundmusic.isPlaying()) {
                    backgroundmusic.start();
                }

                if (game == false && score == -1) {
                    canvas.drawColor(Color.BLUE);
                    paintProperty.setColor(Color.WHITE);
                    paintProperty.setTextSize(128);
                    canvas.drawText("River Raid!",screenWidth/4+40, screenHeight/4, paintProperty);
                    paintProperty.setTextSize(64);
                    canvas.drawText("Click anywhere to play", screenWidth/4+30, screenHeight/2, paintProperty);
                } else if (realtime < 1 || game == false && score > -1) {
                    game = false;
                    realtime = 0;
                    paintProperty.setTextSize(128);
                    canvas.drawColor(Color.BLUE);
                    canvas.drawText("Game Over", screenWidth/4 + 20, screenHeight/3, paintProperty);
                    paintProperty.setTextSize(64);
                    canvas.drawText("Your score was: " + score, screenWidth/4+40, screenHeight/2, paintProperty);
                } else if (realtime > 0 && game && score > -1) {

                    canvas.drawColor(Color.BLUE);

                    time++;
                    if (time%44==0) {
                        realtime--;
                    }
                    paintProperty.setTextSize(96);
                    canvas.drawText(realtime+"", screenWidth/2-50, screenHeight/6, paintProperty);

                    if (time == 100) {
                        time = 0;
                        int obstacle = (int) (Math.random() * 4);
                        switch (obstacle) {
                            case 0:
                                obstacles.add(new Ship((int) (Math.random() * (screenWidth - 250)) + 50, 0));
                                break;
                            case 1:
                                obstacles.add(new Helicopter((int) (Math.random() * (screenWidth - 100)) + 50, 0));
                                break;
                            case 2:
                                obstacles.add(new Airplane((int) (Math.random() * (screenWidth - 100)) + 50, 0));
                                break;
                            case 3:
                                obstacles.add(new Fuel((int)(Math.random() * (screenWidth - 100)) + 50, 0));
                                break;
                        }
                    }

                    if (x <= plane.getWidth() / 2 && ax > 0) {
                        x = plane.getWidth() / 2;
                    } else if (x >= screenWidth - 3 * plane.getWidth() / 2 && ax < 0) {
                        x = screenWidth - 3 * plane.getWidth() / 2;
                    } else {
                        x -= ax * 4;
                    }

                    for (int i = 0; i < obstacles.size(); i++) {
                        Bitmap obstacle = BitmapFactory.decodeResource(getResources(), obstacles.get(i).getImage());
                        if (!(obstacles.get(i) instanceof Bullet)) {
                            obstacles.get(i).setY(obstacles.get(i).getY() + ay);
                        } else {
                            obstacles.get(i).setY(obstacles.get(i).getY() - 10);
                            for (int j = 0; j < obstacles.size(); j++) {
                                Bitmap obstacle2 = BitmapFactory.decodeResource(getResources(), obstacles.get(j).getImage());
                                if (!(obstacles.get(j) instanceof Bullet)) {
                                    if (obstacles.get(i).getX() > obstacles.get(j).getX() && obstacles.get(i).getX() < obstacles.get(j).getX() + obstacle2.getWidth()) {
                                        if (obstacles.get(i).getY() > obstacles.get(j).getY() && obstacles.get(i).getY() < obstacles.get(j).getY() + obstacle2.getHeight()) {
                                            switch (obstacles.get(j).getImage()) {
                                                case R.drawable.ship:
                                                    obstacles.get(j).setImage(R.drawable.brokenship);
                                                    score += 50;
                                                    break;
                                                case R.drawable.helicopter:
                                                    obstacles.get(j).setImage(R.drawable.brokenhelicopter);
                                                    score += 75;
                                                    break;
                                                case R.drawable.airplane:
                                                    obstacles.get(j).setImage(R.drawable.brokenairplane);
                                                    score += 125;
                                                    break;
                                                case R.drawable.fuel:
                                                    obstacles.get(j).setImage(R.drawable.brokenplane);
                                                    break;
                                            }
                                            if (bullethit.isPlaying()) {
                                                bullethit.stop();
                                                try {
                                                    bullethit.prepare();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                bullethit.start();
                                            } else {
                                                bullethit.start();
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (ax > 0 || x >= screenWidth - 3 * plane.getWidth() / 2) {
                            plane = BitmapFactory.decodeResource(getResources(), R.drawable.planeleft);
                        } else if (ax < 0 || x <= plane.getWidth() / 2) {
                            plane = BitmapFactory.decodeResource(getResources(), R.drawable.planeright);
                        } else {
                            plane = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
                        }

                        if (obstacles.size() > 0 && obstacles.get(i).getY() > screenHeight || obstacles.get(i).getY() <= 0) {
                            if (obstacles.get(i).getY() > screenHeight) {
                                score += 25;
                            }
                            if (obstacles.get(i).getY() <= 0) {
                                bulletcounter--;
                            }
                            obstacles.remove(i);
                            if (i > 0) {
                                i--;
                            }

                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                //(obstacles.get(i).getX() > x && obstacles.get(i).getX() + obstacle.getWidth()/2 < x + plane.getWidth()
                        if (obstacles.size() > 0 && obstacles.get(i).getImage() != R.drawable.brokenplane && obstacles.get(i).getImage() != R.drawable.brokenship && obstacles.get(i).getImage() != R.drawable.brokenhelicopter && obstacles.get(i).getImage() != R.drawable.brokenairplane && obstacles.get(i).getImage() != R.drawable.bullet && obstacles.get(i).getY() > y && obstacles.get(i).getY()+obstacle.getHeight() < y + plane.getHeight() && (obstacles.get(i).getX() > x - obstacle.getWidth()) && obstacles.get(i).getX() < x + plane.getWidth()) {
                            if (obstacles.get(i).getImage() == R.drawable.fuel) {
                                realtime+=5;
                                Log.d(TAG, "run: FUEL DETECTED");
                                if (realtime >= 30) {
                                    realtime = 30;
                                }
                                obstacles.remove(i);
                                if (i > 0) {
                                    i--;
                                }
                            } else {
                                plane = BitmapFactory.decodeResource(getResources(), R.drawable.brokenplane);
                                canvas.drawBitmap(plane, x, y, null);
                                game = false;
                                Log.d(TAG, "run: COLLISION DETECTED");

                            }
                        } else {
                            canvas.drawBitmap(plane, x, y, null);
                        }
                        canvas.drawBitmap(obstacle, obstacles.get(i).getX(), obstacles.get(i).getY(), null);
                    }
                }
                holder.unlockCanvasAndPost(canvas);
            }
        }


        public void resume(){
            running=true;
            gameThread=new Thread(this);
            gameThread.start();
        }

        public void pause() {
            running = false;
            while (true) {
                try {
                    gameThread.join();
                } catch (InterruptedException e) {
                }
            }
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            //tilt phone and change position
            if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
                ax=(int)event.values[0];
                if (ax>-.5 && ax <.5) {
                    ax = 0;
                }
                ay = 15-(int)event.values[1];
                if (ay < 3) {
                    ay = 3;
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }//GameSurface
}//Activity