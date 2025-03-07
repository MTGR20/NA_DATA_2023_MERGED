# 🗣️듣말국: 듣고 말하는 국회👂
📺 [듣말국 시연영상 보러가기](https://youtu.be/4Ig8rZNrFz4)  

🔗 [듣말국 앱 다운로드하기 (Android)](https://github.com/MTGR20/NA_DATA_2023_MERGED/releases/download/v1.0.0/app-release.apk)

- **시각장애인의 정치 참여 접근성 증진**을 위한 **생성형 AI 기반 서비스**
- 국회 공공 데이터를 기반으로 만들어진 **사용자 맞춤형 쇼츠**
- 국회에 대한 다양한 궁금증을 해소할 수 있는 **대화형 AI, 챗봇**
  
![포스터](https://github.com/user-attachments/assets/960c902a-acd0-4814-92eb-e43e7f220e78)

## **🐣** 팀원 및 개발 파트 (팀소개)  

|**김유림**|**은지우**|**조예원**|
|---|---|---|
|앱 구성 및 DB|쇼츠|챗봇|  


## **💻** 개발 환경
#### 사용언어  
<img src="https://img.shields.io/badge/Java-F44336?style=flat-square&logo=amazons3&logoColor=white"/>  

#### DBMS  
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white"/> : 숏츠 생성을 위한 스크립트 저장  

#### AI 영상 제작
<img src="https://img.shields.io/badge/플루닛 스튜디오-a84edb?style=flat-square&logo=ploonet&logoColor=white"/> : 숏츠 영상 생성  

#### 개발환경  
<img src="https://img.shields.io/badge/Android Studio-3DDC84?style=flat-square&logo=androidstudio&logoColor=white"/> : 챗봇, 쇼츠 화면 등 안드로이드 앱 개발  
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=flat-square&logo=intellij-idea&logoColor=white"/> : Open API에서 가져온 뉴스 기사를 파싱하여 스크립트를 생성하고, 이를 활용해 AI 영상 제작  

#### 사용 API  
<img src="https://img.shields.io/badge/chatGPT API-000000?style=flat-square&logo=chatgpt&logoColor=white"/> : 사용자 질의응답 및 숏츠 생성 스크립트 요약  
<img src="https://img.shields.io/badge/열린국회정보포털 open API-000000?style=flat-square&logo=na&logoColor=white"/> : 숏츠 생성을 위한 뉴스 기사 수집  
<img src="https://img.shields.io/badge/Google Cloud Text to Speech-4285F4?style=flat-square&logo=googlecloud&logoColor=white"/>
<img src="https://img.shields.io/badge/Google Cloud Speech to Text-4285F4?style=flat-square&logo=googlecloud&logoColor=white"/> : 챗봇 사용 시 음성 상호작용  


## **✏️** 제안 배경

### **1) 시각 장애인의 정치 정보 접근성**

- 시각 장애인의 정부 기관 웹 사이트 접근이 어렵다는 조사 결과
- 특히 공공 데이터와 같이 방대한 정보에서 원하는 정보를 얻기 어려움
- 시각 장애인을 위한 국회 서비스의 부재

**⇒ 시각 장애인이 원하는 정치 정보를 편리하게 볼 수 있는 플랫폼의 필요성**

### **2) 기존 시각 장애인 모바일 서비스 분석**

- 음성을 통해 정보 전달
- 스크린 리더에 최적화된 인터페이스
- 화면 구조에 따라 탐색이 어렵거나 불필요한 정보까지 제공됨
- AI를 활용한 추천 검색 제공

**⇒ 시각 장애인의 접근성을 고려한 UI/UX 디자인 및 AI를 통해 정보 접근성 향상**

### **3) SW 서비스 트렌드**

- 쇼츠, 틱톡 등 숏폼과 같은 빠르고 효율적인 콘텐츠 소비 트렌드
- 다양한 분야의 정보를 편리하게 얻을 수 있는 AI 챗봇

**⇒ 트랜디한 서비스이면서 소리를 통해 정보를 전달할 수 있는 쇼츠와 챗봇**

## **✨** 서비스 소개

### 1) 사용자 맞춤형 쇼츠

- 국회 공공데이터를 분석한 정보를 숏폼 형태의 콘텐츠로 제공
- 정보가 음성으로 전달됨을 고려, 데이터의 핵심 내용을 이해하기 쉽게 요약 전달
- 실시간 업데이트로 새로운 정보를 빠르게 제공

<img width="526" alt="사진 1" src="https://github.com/user-attachments/assets/7dfe818c-d4e8-42cd-8329-bc777c0f9063" />

### 2) 대화형 AI 챗봇

- 국회 공공데이터를 학습한 AI 챗봇을 통해 정확하고 전문성 있는 답변 제공
- 음성을 통해 챗봇과 상호작용, 핵심 정보를 이해하기 쉽게 요약 전달
- 스크린 리더 지원 및 앱 자체 음성 안내 제공

<img width="500" alt="사진 2" src="https://github.com/user-attachments/assets/f1d632ff-546d-42c3-a8cc-02f7b90f871a" />

### 3) 시각 장애인을 위한 디자인

- 간단하고 명확한 구조 및 스크린 리더를 활용할 수 있는 모바일 애플리케이션
- 잔존 시력이 있는 저시력 시각 장애인을 고려, 고대비 테마 및 글자 크기 조절
- 터치, 스와이프 등 스크린 리더에서 사용하는 동작을 차용해 모바일 접근성 향상

<img width="339" alt="사진 3" src="https://github.com/user-attachments/assets/d9505163-ea13-4dc4-9e06-cc2497852661" />

## **✅** 서비스의 특징 및 목표

### 1) 시각 장애인에게 최적화된 환경

- 음성을 통한 상호작용으로 정보를 편리하게 얻을 수 있음
- 자막, 스와이프, 고대비, 글자 옵션 등 시각 정도에 따른 맞춤 서비스

### 2) 신속·정확·간결한 데이터

- 매 실행 시 업데이트 된 정보를 확인해 신속한 정보 제공
- 국회 공공데이터를 기반으로 한 정확하고 전문적인 콘텐츠
- AI를 통해 핵심 내용을 요약해 간결한 정보 전달

### 3) 공익 가치 실현

- 시각 장애인의 온라인 국회 서비스 접근성을 높임
- 국회 활동의 참여 기회를 제공해 민주주의적 가치를 강화
- 정보 불균형을 해소
