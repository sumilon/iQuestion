package com.question.model;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 1000)
    private String question;
    @Column(length = 3000)
    private String answer;
    private String category;

    private String subCategory;

    public QuestionEntity() {
        super();
    }

    public QuestionEntity(String question, String answer, String category, String subCategory) {
        super();
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.subCategory = subCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
