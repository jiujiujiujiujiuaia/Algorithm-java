package zookeeper;


import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author yuchunwei
 */
public class ZooKeeperStart implements Watcher  {

    private static String ip = "129.204.8.88";
    private static int port = 2181;

    public static void main(String[] args) throws Exception {
        ZkClient zc = new ZkClient("129.204.8.88:2181",1000,3000);
      //  ZooKeeper zk = new ZooKeeper("129.204.8.88:2181", 1000, new ZooKeeperStart());
        System.out.println("conneted ok!");
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("accept message");
    }
}   
