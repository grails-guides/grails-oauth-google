package demo

import com.budjb.rabbitmq.publisher.RabbitMessagePublisher

class TestController {
    RabbitMessagePublisher rabbitMessagePublisher //<1>

    def index() {
        render rabbitMessagePublisher.rpc { //<2>
            routingKey = "testqueue"
            body = "Hello!"
        }
    }
}
