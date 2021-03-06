package by.test.dartlen.gallery.map;

import java.util.List;

import by.test.dartlen.gallery.BasePresenter;
import by.test.dartlen.gallery.BaseView;
import by.test.dartlen.gallery.data.remote.Image;

/***
 * Created by Dartlen on 31.10.2017.
 */

public class MapContract  {

    interface Presenter extends BasePresenter{

    }
    interface View extends BaseView<MapContract.Presenter>{
        void showPoints(List<Image> imagesData);
    }
}
