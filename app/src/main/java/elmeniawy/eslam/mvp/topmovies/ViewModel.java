package elmeniawy.eslam.mvp.topmovies;

/**
 * ViewModel
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

class ViewModel {
    private String title;
    private String country;

    public ViewModel(String title, String country) {
        this.country = country;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }
}
