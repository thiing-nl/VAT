package com.vat.service;

import com.vat.model.Shape;

public class ShapeService {

	private Shape[] shapes;
	private int volume;

	public Shape[] getShapes() {
		return this.shapes;
	}

	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void calculateVolume() {
		// TODO - implement ShapeService.calculateVolume
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param shape
	 */
	public void addShape(Shape shape) {
		// TODO - implement ShapeService.addShape
		throw new UnsupportedOperationException();
	}

	/**
	 * Save all current shapes to the database
	 */
	public void saveSQL() {
		// TODO - implement ShapeService.saveSQL
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param path
	 */
	public void saveJSON(String path) {
		// TODO - implement ShapeService.saveJSON
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param path
	 */
	public void saveText(String path) {
		// TODO - implement ShapeService.saveText
		throw new UnsupportedOperationException();
	}

	public void loadSQL() {
		// TODO - implement ShapeService.loadSQL
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param path
	 */
	public void loadJSON(String path) {
		// TODO - implement ShapeService.loadJSON
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param path
	 */
	public void loadText(String path) {
		// TODO - implement ShapeService.loadText
		throw new UnsupportedOperationException();
	}

}