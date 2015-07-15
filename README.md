# YeojoyLibrary
개인적으로 사용하는 것들을 모아놓을 library 프로젝트이다.

library 프로젝트 일때에는 module의 build.gradle에서 아래 "application"을 "library"로 변경해야 한다.

```
apply plugin: 'com.android.application' // App용. .apk가 생성
apply plugin: 'com.android.library'	 // Lib용. .aar이 생성
```

