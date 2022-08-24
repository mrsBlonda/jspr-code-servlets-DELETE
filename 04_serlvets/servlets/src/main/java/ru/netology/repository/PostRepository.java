package ru.netology.repository;

import ru.netology.model.Post;

import java.util.*;

// Stub
public class PostRepository {
  TreeMap<Long, String> treeMap = new TreeMap();
  public List<Post> all() {
    List<Post> posts = new ArrayList<>();
    Post post;
    for (var set : treeMap.entrySet()) {
      post = new Post(set.getKey(), set.getValue());
      posts.add(post);
    }
    return posts;
  }

  public Optional<Post> getById(long id) {
    return Optional.empty();
  }

  public Post save(Post post) {
    long key = 1;
    if (post.getId() == 0) {
      while (treeMap.containsKey(key)) {
        key++;
      }
      treeMap.put(key, post.getContent());
      key++;
    } else {
      treeMap.put(post.getId(), post.getContent());
    }
    return post;
  }

  public void removeById(long id) {
    if (treeMap.containsKey(id)) {
      treeMap.remove(id);
    }
  }
}
