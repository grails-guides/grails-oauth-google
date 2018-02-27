package demo

import com.budjb.rabbitmq.consumer.MessageContext

class BookPageViewConsumer {

    BookPageViewGormService bookPageViewGormService //<1>

    static rabbitConfig = [ //<2>
            queue: "bookQueue"
    ]

    /**
     * Handle an incoming RabbitMQ message.
     *
     * @param body    The converted body of the incoming message.
     * @param context Properties of the incoming message.
     * @return
     */
    def handleMessage(Map body, MessageContext messageContext) {
        println body
        bookPageViewGormService.increment((Long) body.id, (String) body.title) //<3>
    }
}
