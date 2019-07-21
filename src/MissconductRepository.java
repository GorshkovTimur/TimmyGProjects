import java.util.ArrayList;
import java.util.List;

public class MissconductRepository {

    private List<Missconduct> missconducts;
    private static volatile MissconductRepository instance;


    private MissconductRepository(){
        this.missconducts = new ArrayList<>();
    }

    public static MissconductRepository getInstance() {
        MissconductRepository result = instance;

        if (result == null){
            synchronized (MissconductRepository.class){
                result = instance;


            if (result == null) {
                instance = result = new MissconductRepository();
            }
            }
        }

        return instance;
    }


    public void add (Missconduct missconduct){
        missconducts.add(missconduct);
    }


}
