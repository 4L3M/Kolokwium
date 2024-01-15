package Model;

import Model.Direction;

public class RectCoordinate extends Thread{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    Direction direction = Direction.DOWN;
    int isRunning=1;
    public RectCoordinate(int x1, int y1, int x2, int y2, Direction direction){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.direction=direction;
    }
    public void setDirection(Direction direction){
        this.direction=direction;
    }
    @Override
    public void run(){
        while(isRunning==1){
            if(direction==Direction.UP) {
                if(y1>0) {
                    y1 -= 1;
                    y2 -= 1;
                }
            }
            if(direction==Direction.DOWN) {
                if(y2<725){
                    y1 += 1;
                    y2 += 1;
                }

            }
            if(direction == Direction.LEFT) {
                if (x1 > 0){
                    x1 -= 1;
                    x2 -= 1;
                }
            }
            if(direction==Direction.RIGHT) {
                if(x2<900) {
                    x1 += 1;
                    x2 += 1;
                }
            }


            try{
                Thread.sleep(10);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}