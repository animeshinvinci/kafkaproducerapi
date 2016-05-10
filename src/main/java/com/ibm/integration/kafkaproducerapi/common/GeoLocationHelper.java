package com.ibm.integration.kafkaproducerapi.common;

import com.ibm.integration.kafkaproducerapi.beans.GeoLocation;

public class GeoLocationHelper
{

	/**
	 * <ul>
	 * <li>The latitude of any point within the specified distance is greater or
	 * equal to the latitude of the first array element and smaller or equal to
	 * the latitude of the second array element.</li>
	 * <li>If the longitude of the first array element is smaller or equal to
	 * the longitude of the second element, then the longitude of any point
	 * within the specified distance is greater or equal to the longitude of the
	 * first array element and smaller or equal to the longitude of the second
	 * array element.</li>
	 * <li>If the longitude of the first array element is greater than the
	 * longitude of the second element (this is the case if the 180th meridian
	 * is within the distance), then the longitude of any point within the
	 * specified distance is greater or equal to the longitude of the first
	 * array element <strong>or</strong> smaller or equal to the longitude of
	 * the second array element.</li>
	 * </ul>
	 */
	public static double[] boundingCoordinates(GeoLocation location, double distance)
	{

		double radius = 6371.01;

		if (radius < 0d || distance < 0d)
			throw new IllegalArgumentException();

		// angular distance in radians on a great circle
		double radDist = distance / radius;

		double minLat = location.getLatitudeInRadians() - radDist;
		double maxLat = location.getLatitudeInRadians() + radDist;

		double minLon, maxLon;
		if (minLat > GeoLocation.MIN_LAT && maxLat < GeoLocation.MAX_LAT)
		{
			double deltaLon = Math.asin(Math.sin(radDist)
					/ Math.cos(location.getLatitudeInRadians()));
			minLon = location.getLongitudeInRadians() - deltaLon;
			if (minLon < GeoLocation.MIN_LON)
				minLon += 2d * Math.PI;
			maxLon = location.getLongitudeInRadians() + deltaLon;
			if (maxLon > GeoLocation.MAX_LON)
				maxLon -= 2d * Math.PI;
		}
		else
		{
			// a pole is within the distance
			minLat = Math.max(minLat, GeoLocation.MIN_LAT);
			maxLat = Math.min(maxLat, GeoLocation.MAX_LAT);
			minLon = GeoLocation.MIN_LON;
			maxLon = GeoLocation.MAX_LON;
		}

		return new double[]
		{ Math.toDegrees(minLat), 
				Math.toDegrees(maxLat), 
				Math.toDegrees(minLon),
				Math.toDegrees(maxLon) };
		// return new GeoLocation[]
		// { new GeoLocation(Math.toDegrees(minLat), Math.toDegrees(minLon)),
		// new GeoLocation(Math.toDegrees(minLat), Math.toDegrees(maxLon)),
		// new GeoLocation(Math.toDegrees(maxLat), Math.toDegrees(minLon)),
		// new GeoLocation(Math.toDegrees(maxLat), Math.toDegrees(minLon)) };
	}

}
