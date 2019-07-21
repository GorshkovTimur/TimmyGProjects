import java.util.ArrayList;
import java.util.List;

public class MissconductRepository {

    private List<Subscriber> subs;

    private List<Missconduct> missconducts;
    private static volatile MissconductRepository instance;


    private MissconductRepository(){
        this.missconducts = new ArrayList<>();
        this.subs = new ArrayList<>();
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

    public void subscribe(Subscriber subscriber){
        subs.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        subs.remove(subscriber);
    }


    public void add (Missconduct missconduct){
        missconducts.add(missconduct);
        for (Subscriber sub: subs) {
            sub.update();
        }
    }


}
