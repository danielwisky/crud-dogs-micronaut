package br.com.danielwisky.gateways.outputs.mongodb.repositories;

import br.com.danielwisky.gateways.outputs.mongodb.documents.DogDocument;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.PageableRepository;
import org.bson.types.ObjectId;

@MongoRepository
public interface DogDocumentRepository extends PageableRepository<DogDocument, ObjectId> {

}