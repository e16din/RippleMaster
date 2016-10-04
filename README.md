# RippleMaster
[![Release](https://jitpack.io/v/e16din/RippleMaster.svg)](https://jitpack.io/#e16din/RippleMaster)
[![API](https://img.shields.io/badge/android-15%2B-brightgreen.svg)](https://developer.android.com/about/versions/android-4.0.3.html)

Utils to set and update a ripple effect on views.

![Demo](https://github.com/e16din/RippleMaster/blob/master/demo.gif)

## Usage
```java
    //add a ripple effect with default color
    RippleMaster.setRippleBackground(this, R.id.vPushMeButton);

    //add a ripple effect with custom color
    RippleMaster.setRippleBackground(view, Color.RED);

    //add an oval ripple effect with custom color
    RippleMaster.setRippleBackground(view, Color.GREEN, true);

    //add a ripple effect to several views
    final int[] layoutIds = {R.id.vOne, R.id.vTwo, R.id.vThree};
    RippleMaster.setRippleBackground(this, layoutIds);
```

## Download
Step 1. Add it in your root build.gradle at the end of repositories:
```groovy
    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
Step 2. Add the dependency
```groovy
    dependencies {
        compile 'com.github.e16din:RippleMaster:1.0.1'
    }
```

## Dependencies
[RippleDrawable](https://github.com/ozodrukh/RippleDrawable) - used for compatibility with Pre-Lollipop Devices.

## License MIT
Copyright (c) 2016 [Александр Кундрюков (e16din)](http://goo.gl/pzjc8x)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
