#!/bin/bash
# This file is meant to be included by the parent cppbuild.sh script
if [[ -z "$PLATFORM" ]]; then
    pushd ..
    bash cppbuild.sh "$@" proj
    popd
    exit
fi

#SQLITE_VERSION=3360000
#mkdir -p sqlite
#cd sqlite
#download https://www.sqlite.org/2021/sqlite-autoconf-$SQLITE_VERSION.tar.gz sqlite-autoconf-$SQLITE_VERSION.tar.gz
#mkdir -p $PLATFORM
#cd $PLATFORM
#tar -xzvf ../sqlite-autoconf-$SQLITE_VERSION.tar.gz
#cd sqlite-autoconf-$SQLITE_VERSION
#
#case $PLATFORM in
##    android-arm)
##        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
##        make -j $MAKEJ
##        make install
##        ;;
##    android-arm64)
##        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
##        make -j $MAKEJ
##        make install
##        ;;
##    android-x86)
##        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
##        make -j $MAKEJ
##        make install
##        ;;
##    android-x86_64)
##        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
##        make -j $MAKEJ
##        make install
##        ;;
#    linux-x86)
#        CC="gcc -m32 -fPIC" ./configure "--prefix=$(pwd)/.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
#    linux-x86_64)
#        CC="gcc -m64 -fPIC" ./configure "--prefix=$(pwd)/.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
##    macosx-x86_64)
##        ./configure "--prefix=$(pwd)\.." --enable-static
##        make -j $MAKEJ
##        make install
##        ;;
##    windows-x86)
##        nmake -f win32/Makefile.msc zlib.lib
##        mkdir -p ../include ../lib
##        cp zconf.h zlib.h ../include/
##        cp zlib.lib ../lib/
##        ;;
##    windows-x86_64)
##        nmake -f win32/Makefile.msc zlib.lib
##        mkdir -p ../include ../lib
##        cp zconf.h zlib.h ../include/
##        cp zlib.lib ../lib/
##        ;;
#    *)
#        echo "Error: Platform \"$PLATFORM\" is not supported"
#        ;;
#esac
#
#cd ../../..
#
#export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:$(pwd)/sqlite/$PLATFORM/lib"
#export PKG_CONFIG_PATH="$(pwd)/sqlite/$PLATFORM/lib/pkgconfig"
#echo "PKG_CONFIG_PATH=\"$PKG_CONFIG_PATH\""

PROJ_VERSION=4.8.0
#download https://download.osgeo.org/proj/proj-$PROJ_VERSION.tar.gz proj-$PROJ_VERSION.tar.gz

download https://github.com/OSGeo/PROJ/archive/refs/tags/$PROJ_VERSION.tar.gz proj-$PROJ_VERSION.tar.gz
mkdir -p $PLATFORM
cd $PLATFORM
mkdir -p proj-$PROJ_VERSION
cd proj-$PROJ_VERSION
tar -xzvf ../../proj-$PROJ_VERSION.tar.gz --strip-components=1

case $PLATFORM in
#    android-arm)
#        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
#    android-arm64)
#        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
#    android-x86)
#        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
#    android-x86_64)
#        CC="$ANDROID_CC" CFLAGS="$ANDROID_FLAGS" ./configure "--prefix=$(pwd)\.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
    linux-x86)
        CC="gcc -m32 -fPIC" ./configure "--prefix=$(pwd)/.." --enable-static
        make -j $MAKEJ
        make install
        ;;
    linux-x86_64)
        CC="gcc -m64 -fPIC" ./configure "--prefix=$(pwd)/.." --enable-static
        make -j $MAKEJ
        make install
        ;;
#    macosx-x86_64)
#        ./configure "--prefix=$(pwd)\.." --enable-static
#        make -j $MAKEJ
#        make install
#        ;;
#    windows-x86)
#        nmake -f win32/Makefile.msc zlib.lib
#        mkdir -p ../include ../lib
#        cp zconf.h zlib.h ../include/
#        cp zlib.lib ../lib/
#        ;;
#    windows-x86_64)
#        nmake -f win32/Makefile.msc zlib.lib
#        mkdir -p ../include ../lib
#        cp zconf.h zlib.h ../include/
#        cp zlib.lib ../lib/
#        ;;
    *)
        echo "Error: Platform \"$PLATFORM\" is not supported"
        ;;
esac

cd ../..
