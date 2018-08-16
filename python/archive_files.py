'''
	 Question: Given a path to a directory, archive files older
	 than a month, and which can be run on 1st of every month
	 using cron job.
	 Input: directory_path days(optional)
'''
import os

class ArchiveFile(object):
	def __init__(self, directory_path, time_in_days):
		self.directory_path = directory_path
		self.time_in_days = time_in_days
		self.dst_dir = "archives_test/"
		self.files_to_archive = []
		self.file_list = []
		self.sub_dir = []

	def get_directory(self):
		return self.directory_path

	def get_time(self):
		return self.time_in_days

	def get_current_time_in_sec(self):
		'''Returns time since epoch in seconds.
		'''
		import time
		return time.time()

	def check_for_valid_directory(self, directory_path):
		''' Checks for a valid path or directory.
		'''
		if (os.path.exists(directory_path) == True):
			return True
		return False

	def check_for_valid_time(self, time_in_days):
		if time < 0:
			print "---Invalid Time"
			return False
		return True

	def get_last_modified_time_file(self, file_name):
		try:
			return os.path.getmtime(file_name)
		except OSError as e:
			print "---Exception raised: ", e

	def move_to_archives(self):
		'''Move the files to be archived inside archived/
		   folder.
		'''
		files = self.files_to_archive
		
		# Creeate a directory if not already present
		if not os.path.exists(self.dst_dir):
			os.makedirs(self.dst_dir)
		for fl in files:
			fname_idx = fl.rfind("/")
			os.rename(fl, self.dst_dir + fl[fname_idx:])

	def get_sub_directories(self, directory):
		''' Get sub-directories in the current
		    directory but avoid archives/.
		'''
		for val in os.walk(directory):
			for v in val[1]:
				if self.dst_dir not in v:
					self.sub_dir.append(val[0] + "/" + v)
				else:
					print "Checking archives folder too"


	def get_list_of_files_before_threshold(self):
		current_time = self.get_current_time_in_sec()
		time_threshold = self.get_time()
		final_time = current_time - time_threshold * 24 * 60 * 60
		for _file in self.file_list:
			if self.check_for_valid_directory(_file):
				last_mod_time = self.get_modified_time(_file)
				if last_mod_time < final_time:
					self.files_to_archive.append(_file)
			else:
				print "Invalid path for ", _file

	def get_list_of_files(self, directory_path):
		self.get_sub_directories(directory_path)
		self.sub_dir.append(directory_path)
		for directory in self.sub_dir:
			for files in os.walk(directory):
				for f in files[2]:
					self.file_list.append(directory + "/" + f)

	def start(self, directory_path):
		self.get_list_of_files(directory_path)
		self.get_list_of_files_before_threshold()
		print archive_control.files_to_archive
		self.move_to_archives()

if __name__ == '__main__':
	directory_path  = raw_input("Enter the directory where files need to be archived: ")
	time_in_days    = int(raw_input("Enter the time(in days) threshold more than which files to be archived: "))
	archive_control = ArchiveFile(directory_path, time_in_days)
	if archive_control.check_for_valid_directory(directory_path):
		archive_control.start(directory_path)
	else:
		print "----Invalid Directory"
		print "----Exited."


