package com.benz.usecase.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Map;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class Result {
    private String id;
    private String text;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="result")
    private List<ResultFile> files;

    public Result() {
    }

    public void addFile(ResultFile resultFile){
        this.files.add(resultFile);
        if(resultFile.getResult() != this){
            resultFile.setResult(this);
        }
    }
    public Result(String text, List<ResultFile> files) {
        this.id = DomainRegistry.resultRepository().nextIdentity();
        this.text = text;
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<ResultFile> files) {
        this.files = files;
    }

    public void create() {

        DomainRegistry.resultRepository().save(this);
    }
}
