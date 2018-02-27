package demo

import com.budjb.rabbitmq.consumer.MessageContext

class TestConsumer {

    //tag::connectRabbit1[]
    static rabbitConfig = [
            queue: "testqueue"
    ]
    //end::connectRabbit1[]

    /**
     * Handle an incoming RabbitMQ message.
     *
     * @param body    The converted body of the incoming message.
     * @param context Properties of the incoming message.
     * @return
     */
    //tag::handleMessage1[]
    def handleMessage(String body, MessageContext context) {
        println body
        return "Hello to you, too!"
    }
    //end::handleMessage1[]
}
