package todolist.model;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class Thing {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "THING_TITLE")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
