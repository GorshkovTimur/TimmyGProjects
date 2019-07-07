public class MissconductFacade {


    private MissconductRepository mRepository;

    public MissconductFacade(MissconductRepository mRepository) {
        this.mRepository = mRepository;
    }

    public void createLateness(Lateness lateness){
        mRepository.add(lateness);
    }

    public void createAbsenteeism(Absenteeism absenteeism){
        mRepository.add(absenteeism);
    }
}
