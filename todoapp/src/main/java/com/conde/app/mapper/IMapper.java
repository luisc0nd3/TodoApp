package com.conde.app.mapper;

public interface IMapper <I, O>{
  public O map(I in);
}
