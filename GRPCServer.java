package grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GRPCServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080)
                .addService(new MessagingServiceImpl())
                .build();

        server.start();
        System.out.println("gRPC Server started");
        server.awaitTermination();
    }

    static class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {
        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            // Implémentation de la logique d'envoi de message
        }

        @Override
        public void getMessagesForUser(UserRequest request, StreamObserver<MessagesResponse> responseObserver) {
            // Implémentation de la logique de récupération des messages pour un utilisateur donné
        }
    }
}





