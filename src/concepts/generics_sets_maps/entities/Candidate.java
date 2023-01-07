package concepts.generics_sets_maps.entities;

import java.util.Objects;

public class Candidate {

    private String name;
    private Double votes;

    public Candidate(String name, Double votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVotes() {
        return votes;
    }

    public void setVotes(Double votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate candidate)) return false;
        return getName().equals(candidate.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
