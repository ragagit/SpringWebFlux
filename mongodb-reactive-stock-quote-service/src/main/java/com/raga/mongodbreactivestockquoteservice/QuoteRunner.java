package com.raga.mongodbreactivestockquoteservice;

import com.raga.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.raga.mongodbreactivestockquoteservice.domain.Quote;
import com.raga.mongodbreactivestockquoteservice.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository repository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository repository) {
        this.stockQuoteClient = stockQuoteClient;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Flux<Quote> quoteFlux = repository.findWithTailableCursorBy();
        //Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();

        //quoteFlux.doOnEach(System.out::println).subscribe();
        //quoteFlux.subscribe(System.out::println);


//        Disposable disposable = quoteFlux.subscribe(quote -> {
//            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#* Id: " + quote.getId());
//        });
//
//        disposable.dispose();
    }
}

