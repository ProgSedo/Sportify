import java.util.*;

public abstract class Match
{
    private Date start;
    private Date finish;

    private int teamSize;
    private User[] team1;
    private User[] team2;

    public Match(int sizeOfTeam, Date begin, Date end)
    {
        teamSize = sizeOfTeam;
        start = begin;
        finish = end;
    }
}