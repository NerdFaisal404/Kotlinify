package goldzweigapps.com.reactive

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by gilgoldzweig on 30/08/2017.
 */
private val mainThread = AndroidSchedulers.mainThread()
private val newThread = Schedulers.newThread()
private val ioThread = Schedulers.io()

fun <T> Observable<T>.runSafeOnMain(): Observable<T> =
        observeOn(mainThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete { unsubscribeOn(newThread) }


fun <T> Observable<T>.runSafeOnIO(): Observable<T> =
        observeOn(ioThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete { unsubscribeOn(newThread) }

fun <T> Flowable<T>.runSafeOnMain(): Flowable<T> =
        observeOn(mainThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete { unsubscribeOn(newThread) }

fun <T> Flowable<T>.runSafeOnIO(): Flowable<T> =
        observeOn(ioThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete { unsubscribeOn(newThread) }

fun <T> Single<T>.runSafeOnMain(): Single<T> =
        observeOn(mainThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnSuccess { unsubscribeOn(newThread) }

fun <T> Single<T>.runSafeOnIO(): Single<T> =
        observeOn(ioThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnSuccess { unsubscribeOn(newThread) }

fun Completable.runSafeOnMain(): Completable =
        observeOn(mainThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete({ unsubscribeOn(newThread) })

fun Completable.runSafeOnIO(): Completable =
        observeOn(ioThread)
                .subscribeOn(newThread)
                .doOnError({ unsubscribeOn(newThread) })
                .doOnComplete({ unsubscribeOn(newThread) })


