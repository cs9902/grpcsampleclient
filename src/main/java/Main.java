import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.samples.helloworld.GreeterGrpc;
import io.grpc.samples.helloworld.HelloReply;
import io.grpc.samples.helloworld.HelloRequest;

/**
 * Created by huangxueqiong on 2017/3/11.
 */
public class Main {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build();

        // 使用我们从proto文件生成的GreeterGrpc类提供的newBlockingStub方法指定channel创建stubs
        GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName("test").build();
        HelloReply response = blockingStub.sayHello(request);
        System.out.println(response.getMessage());

    }

}
