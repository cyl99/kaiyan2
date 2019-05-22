package com.cyl.kaiyan.view.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cyl.kaiyan.R;
import com.cyl.kaiyan.customview.PreViewGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


public class Main2Activity extends GSYBaseActivityDetail<StandardGSYVideoPlayer> {
    private PreViewGSYVideoPlayer mWebPlayer;
    private int backupRendType;
    private String mVideo;
    private String mTitle;
    private String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        //视频播放地址
        mVideo = getIntent().getStringExtra("url");
        //视频标题
        mTitle = getIntent().getStringExtra("text");
        img = getIntent().getStringExtra("img");
        initView();
        backupRendType = GSYVideoType.getRenderType();

        //设置为Surface播放模式，注意此设置是全局的
        GSYVideoType.setRenderType(GSYVideoType.SUFRACE);

        //普通模式
        resolveNormalVideoUI();
        initVideoBuilderMode();


        mWebPlayer.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                    mWebPlayer.getCurrentPlayer().setRotateViewAuto(!lock);
                }
            }
        });
        orientationUtils.setRotateWithSystem(false);
    }

    private void initView() {
        mWebPlayer = (PreViewGSYVideoPlayer) findViewById(R.id.detail_player);
    }

    @Override
    public StandardGSYVideoPlayer getGSYVideoPlayer() {
        return mWebPlayer;
    }

    @Override
    public GSYVideoOptionBuilder getGSYVideoOptionBuilder() {
        //String url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        //String url = "https://d131x7vzzf85jg.cloudfront.net/upload/documents/paper/b2/61/00/00/20160420_115018_b544.mp4";
        //增加封面。内置封面可参考SampleCoverVideo
        ImageView imageView = new ImageView(this);
        loadCover(imageView, img);
        return new GSYVideoOptionBuilder()
                .setThumbImageView(imageView)
                .setUrl(mVideo)
                .setCacheWithPlay(false)
                .setRotateWithSystem(false)
                .setVideoTitle(mTitle)
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setShowFullAnimation(false)
                .setNeedLockFull(true);
    }

    @Override
    public void clickForFullScreen() {
    }

    /**
     * 是否启动旋转横屏，true表示启动
     * @return true
     */
    @Override
    public boolean getDetailOrientationRotateAuto() {
        //mWebPlayer.startWindowFullscreen(Main3Activity.this, true, true);
        return false;
    }

    private void resolveNormalVideoUI() {
        //增加title
        mWebPlayer.getTitleTextView().setVisibility(View.GONE);
        mWebPlayer.getBackButton().setVisibility(View.GONE);
    }

    private void loadCover(ImageView imageView, String url) {

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.ic_action_menu);

        Glide.with(this.getApplicationContext())
                .setDefaultRequestOptions(
                        new RequestOptions()
                                .frame(3000000)
                                .centerCrop()
                                .error(R.mipmap.ic_action_play)
                                .placeholder(R.mipmap.ic_action_play))
                .load(url)
                .into(imageView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //设置为GL播放模式，才能支持滤镜，注意此设置是全局的
        GSYVideoType.setRenderType(backupRendType);
    }

}
