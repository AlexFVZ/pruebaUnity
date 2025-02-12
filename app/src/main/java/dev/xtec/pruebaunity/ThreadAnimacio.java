package dev.xtec.pruebaunity;

public class ThreadAnimacio extends Thread {
    CercleView cView;

    public ThreadAnimacio(CercleView v){
        this.cView=v;
    }

    @Override
    public void run(){
        while(true){
            try {
                sleep(20);
                cView.mou();
                cView.postInvalidate();
            }catch (InterruptedException e){

            }
        }
    }
}
