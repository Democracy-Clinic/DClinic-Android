package com.dclinic.patient.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dclinic.patient.AmbulanceDataItem;
import com.dclinic.patient.AmbulanceModel;
import com.dclinic.patient.data.error.NegativeResult;
import com.dclinic.patient.data.error.PositiveResult;
import com.dclinic.patient.data.error.ResultEvent;
import com.dclinic.patient.domain.repository.AmbulanceRepository;
import com.dclinic.patient.domain.repository.AmbulanceRepositoryImpl;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * Created by HeinHtetZaw on 3/5/21.
 */
public class AmbulanceViewModel extends AndroidViewModel {

    private AmbulanceRepository ambulanceRepository;

    private MutableLiveData<ResultEvent<List<AmbulanceDataItem>>> ambulanceListLiveData = new MutableLiveData<>();

    public AmbulanceViewModel(@NonNull Application application) {
        super(application);
        ambulanceRepository =  new AmbulanceRepositoryImpl(application.getApplicationContext());
    }

    public MutableLiveData<ResultEvent<List<AmbulanceDataItem>>> getAmbulanceListLiveData(){
        return ambulanceListLiveData;
    }

    public void fetchAmbulanceList(){
       ambulanceRepository.getAmbulanceList()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<AmbulanceDataItem>>() {
                @Override
                public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                }

                @Override
                public void onNext(@io.reactivex.rxjava3.annotations.NonNull List<AmbulanceDataItem> ambulanceDataItems) {
                    ambulanceListLiveData.postValue(new PositiveResult<List<AmbulanceDataItem>>(ambulanceDataItems));
                }

                @Override
                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                    ambulanceListLiveData.postValue(new NegativeResult(e.getMessage()));
                }

                @Override
                public void onComplete() {

                }
            });
    }
}
