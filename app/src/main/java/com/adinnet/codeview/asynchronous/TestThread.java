package com.adinnet.codeview.asynchronous;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.adinnet.codeview.viewTouchEvent.MyTextView;

import javax.xml.transform.Result;

/**
 * @author zoujian.
 * @date 2018/9/20
 */

public class TestThread {

    public class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            // 实现具体逻辑，文件读写，网络请求
        }
    }


    public class MyRunnalbe implements Runnable{
        @Override
        public void run() {

        }
    }

    public class MyHandlerThread extends HandlerThread{
        private Handler mHandler;

        public MyHandlerThread(String name) {
            super(name);
        }

        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            mHandler = new Handler(getLooper()){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what){
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                }
            };
        }


        public void publishedMethod1(){
            mHandler.sendEmptyMessage(1);
        }

        public void pulishMethod2(){
            mHandler.sendEmptyMessage(2);
        }
    }



    public void startThread(){
        MyThread myThread = new MyThread();
        myThread.start();  // 使用start 启动线程
    }

    public void startThread2(){
        MyRunnalbe runnalbe = new MyRunnalbe();
        Thread thread = new Thread(runnalbe);
        thread.start();
    }

    public class FullTast extends AsyncTask<Void,Void,Result>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Result doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);
        }

        @Override
        protected void onCancelled(Result result) {
            super.onCancelled(result);
        }
    }
}
