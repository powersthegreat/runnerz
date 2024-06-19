package powersthegreat.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Run findById(Integer id) {
        return runs.stream()
                   .filter(run -> run.id() == id)
                   .findFirst()
                   .get();
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                         "Morning Run", 
                         LocalDateTime.now(), 
                         LocalDateTime.now().plusHours(2), 
                         3, 
                         Location.OUTDOOR));

        runs.add(new Run(2, 
                         "Evening Run", 
                         LocalDateTime.now(), 
                         LocalDateTime.now().plusHours(1), 
                         6, 
                         Location.OUTDOOR));
    }
}