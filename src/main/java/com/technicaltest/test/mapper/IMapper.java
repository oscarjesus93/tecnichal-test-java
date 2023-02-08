package com.technicaltest.test.mapper;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface IMapper <I, O> {

    public O MapDtoEntity(I in) throws UnsupportedEncodingException, NoSuchAlgorithmException;

}
