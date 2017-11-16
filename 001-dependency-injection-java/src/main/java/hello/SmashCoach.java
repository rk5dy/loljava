package hello;

public class SmashCoach implements Coach {
  private FortuneService fortuneService;

  public SmashCoach() {

  }

  public SmashCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "do 20x multi shines on shield";
  }

  @Override
  public String getDailyFortune() {
    return "Win Evo pls! " + fortuneService.getFortune();
  }
}
