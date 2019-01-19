# android-audio
AudioRecord &amp;&amp; AudioTrack Demo

### 功能
* [x] 支持播放参数设置（默认参数是16k,16bit,单声道）
* [x] 支持边录音边播放
* [x] 支持录音保存文件
* [x] 支持播放录音文件


### 怎么使用?
#第一步，实例化
```java
private MicManager manager=null;
manager=MicManager.getInstance();
```

#第二步，设置音频参数（默认参数是16k,16bit,单声道）
```java
private MicManager manager=null;
/**
 * int sampleRateInHz, 采样率
 * int bitWidth, 采样位宽
 * int channel 采样通道
 */
manager.setAudioParameters(44100, AudioFormat.ENCODING_PCM_16BIT,AudioFormat.CHANNEL_IN_STEREO);
```

#第三步，功能使用
> 边录边播 `manager.startRecord(MicManager.MODE_OUT_MIC);`

> 录音保存至文件 `manager.startRecord(MicManager.MODE_RECORD_FILE);`

> 停止录制 `manager.stopRecord();`

> 播放录音文件 `manager.playRecordFile();`

> 停止播放录音文件 `manager.stopPlay();`

> 获取当前的状态 `manager.getOperationStatus();`
 | 状态值 |:-----------------|  MicManager.MODE_DEFAULT   | MicManager.MODE_OUT_MIC |  MicManager.MODE_RECORD_FILE | MicManager.MODE_PLAY_FILE |
 | 含义   |:-----------------|  默认状态                  | 边录边播模式            |  录音保存至文件模式          | 播放录音文件模式          | 


### Contact me
E-mail:1262135886@qq.com<br>
CSDN blog address:http://blog.csdn.net/qq_33750826
