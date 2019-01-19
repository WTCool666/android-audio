package com.example.recorder;

import android.media.AudioFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BasePermissionActivity implements View.OnClickListener {

    private Button btn_playOutMic,btn_saveFile,btn_playFile;
    private MicManager manager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        manager=MicManager.getInstance();
        manager.setAudioParameters(44100, AudioFormat.ENCODING_PCM_16BIT,AudioFormat.CHANNEL_IN_STEREO );
    }

    private void initView(){
        btn_playFile=findViewById(R.id.btn_playFile);
        btn_saveFile=findViewById(R.id.btn_saveFile);
        btn_playOutMic=findViewById(R.id.btn_playOutMic);
        btn_playOutMic.setOnClickListener(this);
        btn_playFile.setOnClickListener(this);
        btn_saveFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_playFile:
                if (manager.getOperationStatus()==MicManager.MODE_PLAY_FILE){
                    manager.stopPlay();
                    btn_playFile.setText("播放录音文件");
                    btn_saveFile.setClickable(true);
                    btn_playOutMic.setClickable(true);
                }else{
                    manager.playRecordFile();
                    btn_playFile.setText("停止播放文件");
                    btn_saveFile.setClickable(false);
                    btn_playOutMic.setClickable(false);
                }
                break;
            case R.id.btn_playOutMic:
                if (manager.getOperationStatus()==MicManager.MODE_OUT_MIC){
                    manager.stopRecord();
                    btn_playOutMic.setText("边录边播");
                    btn_saveFile.setClickable(true);
                    btn_playFile.setClickable(true);
                }else{
                    manager.startRecord(MicManager.MODE_OUT_MIC);
                    btn_playOutMic.setText("关闭mic");
                    btn_saveFile.setClickable(false);
                    btn_playFile.setClickable(false);
                }
                break;
            case R.id.btn_saveFile:
                if (manager.getOperationStatus()==MicManager.MODE_RECORD_FILE){
                    manager.stopRecord();
                    btn_saveFile.setText("录至文件");
                    btn_playFile.setClickable(true);
                    btn_playOutMic.setClickable(true);
                }else{
                    manager.startRecord(MicManager.MODE_RECORD_FILE);
                    btn_saveFile.setText("停止录制");
                    btn_playFile.setClickable(false);
                    btn_playOutMic.setClickable(false);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.destroy();
        manager=null;
    }
}
