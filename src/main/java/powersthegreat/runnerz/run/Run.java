package powersthegreat.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

        public Run {
                // if (id == null) {
                //         throw new IllegalArgumentException("id is required");
                // }
                // if (title == null) {
                //         throw new IllegalArgumentException("title is required");
                // }
                // if (startedOn == null) {
                //         throw new IllegalArgumentException("startedOn is required");
                // }
                // if (completedOn == null) {
                //         throw new IllegalArgumentException("completedOn is required");
                // }
                // if (miles == null) {
                //         throw new IllegalArgumentException("miles is required");
                // }
                // if (location == null) {
                //         throw new IllegalArgumentException("location is required");
                // }
                if (!completedOn.isAfter(startedOn)) {
                        throw new IllegalArgumentException("completedOn must be after startedOn");
                }
        }

}