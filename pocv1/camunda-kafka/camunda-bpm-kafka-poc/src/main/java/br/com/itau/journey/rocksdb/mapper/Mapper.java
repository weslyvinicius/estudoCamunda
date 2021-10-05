package br.com.itau.journey.rocksdb.mapper;

import br.com.itau.journey.rocksdb.mapper.exception.DeserializationException;
import br.com.itau.journey.rocksdb.mapper.exception.SerializationException;

/**
 * Interface that defines methods for mapping to bytes.
 *
 * @param <T> Value type that should be serialized or deserialized.
 */
public interface Mapper<T> {

    /**
     * Try to serialize entity to byte array.
     *
     * @param t entity that should be serialized to byte array.
     * @return byte array of serialized entity.
     * @throws SerializationException when it's not possible to serialize entity.
     */
    byte[] serialize(T t) throws SerializationException, SerializationException;

    /**
     * Try to deserialize byte array to entity.
     *
     * @param bytes that should be deserialized to entity.
     * @return deserialized entity
     * @throws DeserializationException when it's not possible to deserialize entity.
     */
    T deserialize(byte[] bytes) throws DeserializationException, DeserializationException;
}
