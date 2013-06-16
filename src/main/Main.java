package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.io.BufferedReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Main {

	// display constants
	//private static final int    DISPLAY_WIDTH     = 1280;
	//private static final int    DISPLAY_HEIGHT    = 720;
	//private static final String DISPLAY_TITLE     = "";
	//private static final int    TARGET_FRAME_RATE = 60;

	// perspective constants
	//private static final float FIELD_OF_VIEW = 65.0f;
	//private static final float NEAR_PLANE    = 0.001f;
	//private static final float FAR_PLANE     = 100.0f;

	// UNCOMMENT: if you want to use shaders
	/*// shaders
	private int shaderProgram;
	private int vertexShader;
	private int fragmentShader;*/

	// UNCOMMENT: if you want to use a 3D environment
	// private Camera camera;

	// UNCOMMENT: if you want to use delta
	// private long lastFrameSystemTime;

	public Main() {
		initializeProgram();
		programLoop();
		exitProgram();
	}

	private void initializeProgram() {
		initializeDisplay();
		initializeGL();
		initializeVariables();
	}

	private void initializeDisplay() {
		// create the display
		try {
			Display.setDisplayMode(new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT));
			Display.setTitle(DISPLAY_TITLE);
			Display.create();
		} catch(LWJGLException exception) {
			exception.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}

	private void initializeGL() {
		// edit the projection matrix
		glMatrixMode(GL_PROJECTION);
		// reset the projection matrix
		glLoadIdentity();

		// UNCOMMENT: if you want to use a 3D projection matrix
		//gluPerspective(FIELD_OF_VIEW, (float) (DISPLAY_WIDTH / DISPLAY_HEIGHT), NEAR_PLANE, FAR_PLANE);

		// switch back to the model view matrix
		glMatrixMode(GL_MODELVIEW);

		// UNCOMMENT: if you want to use shaders
		//initializeShaders();
	}

	// UNCOMMENT: if you want to use shaders
	/*
	private void initializeShaders() {
		// create the program and shaders
		shaderProgram = glCreateProgram();
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

		// get a string representation of the shader
		StringBuilder vertexShaderSource = loadShaderSourceFromPath("src/shader/shader.vertex");
		StringBuilder fragmentShaderSource = loadShaderSourceFromPath("src/shader/shader.fragment");

		// compile the shaders
		compileShader(vertexShader, vertexShaderSource);
		compileShader(fragmentShader, fragmentShaderSource);

		// attach the shaders to the program
		glAttachShader(shaderProgram, vertexShader);
		glAttachShader(shaderProgram, fragmentShader);

		// link and validate the program
		glLinkProgram(shaderProgram);
		glValidateProgram(shaderProgram);
	}

	private StringBuilder loadShaderSourceFromPath(String path) {
		StringBuilder shaderSource = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			exitProgramWithErrorCode(2);
		}
		return shaderSource;
	}

	private void compileShader(int shaderHandle, StringBuilder shaderSource) {
		glShaderSource(shaderHandle, shaderSource);
		glCompileShader(shaderHandle);
		if (glGetShaderi(shaderHandle, GL_COMPILE_STATUS) == GL_FALSE)
			System.out.println("Not able to compile shader " + shaderHandle + "\n" + "With source: " + shaderSource);
	}*/

	private void initializeVariables() {
		// UNCOMMENT: if you want to use a 3D environment
		// camera = new Camera(0.0f, 0.0f, 0.0f);

		// UNCOMMENT: if you want to use delta
		// getDelta();

		// TODO: initialize program specific variables
	}

	private void programLoop() {
		while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			// UNCOMMENT: if you want to use shaders
			// glUseProgram(shaderProgram);

			// UNCOMMENT: if you want to use delta
			// int delta = getDelta();
			renderGL();
			update();

			// UNCOMMENT: if you want to use shaders
			//glUseProgram(0);
			Display.update();
			Display.sync(TARGET_FRAME_RATE);
		}
	}

	private void renderGL() {
		// clear both buffers
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// TODO: render

		// UNCOMMENT: if you want to use the camera
		// camera.lookThrough();
	}

	private void update() {
		// TODO: update
	}

	// uncomment if you need to create FloatBuffers
	/*private FloatBuffer createFloatBuffer(float[] data) {
		FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(data.length);
		floatBuffer.put(data);
		floatBuffer.flip();
		return floatBuffer;
	}*/

	private void exitProgram() {
		destroyBuffers();
		destroyShaders();
		Display.destroy();
		System.exit(0);
	}

	private void exitProgramWithErrorCode(int error) {
		System.err.println("Terminated with error code " + error);
		destroyBuffers();
		Display.destroy();
		System.exit(error);
	}

	private void destroyBuffers() {
		// TODO: destroy buffers
	}

	// UNCOMMENT: if you want to use shaders
	/*
	private void destroyShaders() {
		glDeleteProgram(shaderProgram);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}*/

	// UNCOMMENT: if you want to use delta
	/*private long getSystemTimeInMilliseconds() {
		// return the system time in ms
		return System.nanoTime() / 1000000;
	}

	private int getDelta() {
		long time = getSystemTimeInMilliseconds();
		int delta = (int) (time - lastFrameSystemTime);
		lastFrameSystemTime = time;
		return delta;
	}*/

	public static void main(String[] args) {
		new Main();
	}

}
