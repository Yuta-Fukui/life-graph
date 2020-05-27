package com.lifegraph.team20.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.util.StringUtils;

public class DateUtil {

  private static final ZoneId ZONE_ID_UTC = ZoneId.of("UTC");
  private static final ZoneId ZONE_ID_JST = ZoneId.of("Asia/Tokyo");
  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static LocalDateTime toJSTLocalDateTime(String strTimestamp) {
    if (StringUtils.isEmpty(strTimestamp)) {
      return null;
    }
    sdf.setTimeZone(TimeZone.getTimeZone(ZONE_ID_UTC));
    Date formatDate = null;
    try {
      formatDate = sdf.parse(strTimestamp);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    LocalDateTime def = LocalDateTime.ofInstant(formatDate.toInstant(), ZONE_ID_UTC);
    ZonedDateTime jst = def.atZone(ZONE_ID_UTC).withZoneSameInstant(ZONE_ID_JST);
    return jst.toOffsetDateTime().toLocalDateTime();
  }
}
