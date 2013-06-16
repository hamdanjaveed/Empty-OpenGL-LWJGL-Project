package camera;

import org.lwjgl.util.vector.Vector3f;
import static org.lwjgl.opengl.GL11.*;

public class Camera {

	private Vector3f position;
	private float yaw;
	private float pitch;

	public static final float MOVE_SPEED = 0.01f;
	public static final float YAW_AND_PITCH_SPEED = 0.01f;

	public Camera(float x, float y, float z) {
		position = new Vector3f(x, y, z);
	}

	public void yawBy(float amount) {
		yaw += amount;
	}

	public void pitchBy(float amount) {
		pitch += amount;
	}

	//moves the camera forward relative to its current rotation (yaw)
	public void walkForward(float distance) {
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw));
	}

	//moves the camera backward relative to its current rotation (yaw)
	public void walkBackwards(float distance) {
		position.x += distance * (float)Math.sin(Math.toRadians(yaw));
		position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
	}

	//strafes the camera left relitive to its current rotation (yaw)
	public void strafeLeft(float distance) {
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
	}

	//strafes the camera right relitive to its current rotation (yaw)
	public void strafeRight(float distance) {
		position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
		position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
	}

	public void lookThrough() {
		glLoadIdentity();
		glRotatef(pitch, 1.0f, 0.0f, 0.0f);
		glRotatef(yaw, 0.0f, 1.0f, 0.0f);
		glTranslatef(position.x, position.y, position.z);
	}

	public void flyUp(float distance) {
		position.y -= distance;
	}

	public void flyDown(float distance) {
		position.y += distance;
	}

}