package elmeniawy.eslam.mvp.topmovies;

import io.reactivex.Observable;

/**
 * TopMoviesActivityMVP
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public interface TopMoviesActivityMVP {
    interface View {
        void updateData(ViewModel viewModel);

        void showSnackBar(String s);
    }

    interface Presenter {
        void loadData();

        void rxUnsubscribe();

        void setView(TopMoviesActivityMVP.View view);
    }

    interface Model {
        Observable<ViewModel> result();
    }
}
