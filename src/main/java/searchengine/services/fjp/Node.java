package searchengine.services.fjp;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@Getter
@Setter
public class Node {
    private String url;
    private Set<Node> children;
    private int level;

    public Node(String url){
        this.url = url;
        children = ConcurrentHashMap.newKeySet();
    }

    public void addChild(Node node){
        children.add(node);
        node.setLevel(level + 1);
    }

    @Override
    public String toString() {
        return "\t".repeat(getLevel()).concat(url).concat("\n");
    }

    public List<String> getAllUrls() throws IOException {
        List<String> urlsList = new ArrayList<>();
        urlsList.add(this.toString());
        for (Node child : children) {
            urlsList.addAll(child.getAllUrls());
        }
        return urlsList;
    }
}
