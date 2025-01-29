// IMusicAidlInterface.aidl
package com.example.androiditis2024;

// Declare any non-default types here with import statements

interface IMusicAidlInterface {
     void playMusic();
     void pauseMusic();
     void printHello();

     void setMusic(in Song song);
}

parcelable Song;