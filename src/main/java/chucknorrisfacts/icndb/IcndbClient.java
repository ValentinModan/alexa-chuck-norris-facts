package chucknorrisfacts.icndb;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.Optional;

@Client("http://api.icndb.com")
public interface IcndbClient {

    @Get("/jokes/random/?limitTo=[nerdy]")
    Optional<Fact> getRandomFact();
}
