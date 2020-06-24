package ru.Bykova.JAVA_lessons.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {//получить инфу о коммитах
        Github github = new RtGithub("8e0f6dc57022a932d70988eaa2229b3b84a75107");//соед-е с гитхабом
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Zhanna1511", "JAVA_lessons")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
