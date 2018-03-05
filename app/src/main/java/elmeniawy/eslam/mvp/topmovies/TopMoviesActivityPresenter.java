package elmeniawy.eslam.mvp.topmovies;

import android.support.annotation.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * TopMoviesActivityPresenter
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public class TopMoviesActivityPresenter implements TopMoviesActivityMVP.Presenter {
    @Nullable
    private TopMoviesActivityMVP.View view;

    private TopMoviesActivityMVP.Model model;
    private Disposable disposable = null;

    public TopMoviesActivityPresenter(TopMoviesActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        disposable = model
                .result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayData, this::displayError);
    }

    @Override
    public void rxUnsubscribe() {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void setView(TopMoviesActivityMVP.View view) {
        this.view = view;
    }

    private void displayError(Throwable throwable) {
        throwable.printStackTrace();

        if (view != null) {
            view.showSnackBar("Error getting movies");
        }
    }

    private void displayData(ViewModel viewModel) {
        if (view != null) {
            view.updateData(viewModel);
        }
    }
}
