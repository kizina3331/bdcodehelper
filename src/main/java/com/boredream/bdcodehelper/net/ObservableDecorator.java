package com.boredream.bdcodehelper.net;

import com.boredream.bdcodehelper.BoreConstants;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 观察者装饰器
 */
public class ObservableDecorator {

    public static <T> Observable<T> decorate(Observable<T> observable) {
        Observable<T> newObservable;
        if(BoreConstants.isUnitTest) {
            newObservable = observable.subscribeOn(Schedulers.immediate())
                    .observeOn(Schedulers.immediate());
        } else {
            newObservable = observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return newObservable;
    }
}
