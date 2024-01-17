package com.example.na_data_2023_app;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2Adapter viewPager2Adapter
                = new ViewPager2Adapter(getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager2 = findViewById(R.id.pager);
        viewPager2.setAdapter(viewPager2Adapter);

        // TabLayout 기능
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("쇼츠");
                        break;
                    case 1:
                        tab.setText("챗봇");
                        break;
                    default:
                        tab.setText("Tab " + (position + 1));
                }
            }
        }).attach();

        // TTS 설정
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=android.speech.tts.TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { // 선택 X -> 선택 O
                if (tab.getPosition() ==0) {
                    tts.speak("shorts 화면입니다.", TextToSpeech.QUEUE_FLUSH, null, null);
                }else if (tab.getPosition() == 1){
                    tts.speak("ChatBot 화면입니다.", TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
