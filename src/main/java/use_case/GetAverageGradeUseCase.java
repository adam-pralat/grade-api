package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        float sum = 0;
        for (String name: team.getMembers()) {
            Grade grade = gradeDB.getGrade(name, course);
            sum += grade.getGrade();
        }

        return sum / team.getMembers().length;
    }
}
